#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* 双向链表实现 */
typedef struct ListNode {
    int ele;
    struct ListNode *prev;
    struct ListNode *next;
} ListNode;

ListNode *new_ListNode(int ele) {
    ListNode *node = (ListNode *) malloc(sizeof(ListNode));
    node->ele = ele;
    node->prev = NULL;
    node->next = NULL;
    return node;
}

typedef struct LinkedList {
    int size;
    ListNode *dummyHead;
    ListNode *dummyTail;
} LinkedList;

LinkedList *new_LinkedList() {
    LinkedList *link = (LinkedList *) malloc(sizeof(LinkedList));
    link->size = 0;
    link->dummyHead = new_ListNode(-1);
    link->dummyTail = new_ListNode(-1);
    link->dummyHead->next = link->dummyTail;
    link->dummyTail->prev = link->dummyHead;
    return link;
}

void addLast_LinkedList(LinkedList *link, int ele) {
    ListNode *node = new_ListNode(ele);

    ListNode *pre = link->dummyTail->prev;

    pre->next = node;
    node->prev = pre;

    node->next = link->dummyTail;
    link->dummyTail->prev = node;

    link->size++;
}

void addFirst_LinkedList(LinkedList *link, int ele) {
    ListNode *node = new_ListNode(ele);

    ListNode *nxt = link->dummyHead->next;

    nxt->prev = node;
    node->next = nxt;

    link->dummyHead->next = node;
    node->prev = link->dummyHead;

    link->size++;
}

int removeFirst_LinkedList(LinkedList *link) {
    if (link->size == 0) exit(-1);

    ListNode *removed = link->dummyHead->next;

    link->dummyHead->next = removed->next;
    removed->next->prev = link->dummyHead;

    link->size--;

    return removed->ele;
}

void removeLast_LinkedList(LinkedList *link) {
    if (link->size == 0) exit(-1);

    ListNode *removed = link->dummyTail->prev;

    removed->prev->next = link->dummyTail;
    link->dummyTail->prev = removed->prev;

    link->size--;
}

void removeEle(LinkedList *link, int ele) {
    ListNode *cur = link->dummyHead->next;

    while (cur != link->dummyTail) {
        if (cur->ele == ele) {
            ListNode *pre = cur->prev;
            ListNode *nxt = cur->next;

            pre->next = nxt;
            nxt->prev = pre;

            link->size--;

            break;
        }
        cur = cur->next;
    }
}

void addEle(LinkedList *link, int ele) {
    ListNode *cur = link->dummyHead->next;

    while (cur != link->dummyTail) {
        if (cur->ele == ele) {
            ListNode *node = new_ListNode(ele);

            ListNode *pre = cur->prev;
            pre->next = node;
            node->prev = pre;

            node->next = cur;
            cur->prev = node;

            link->size++;

            break;
        }
        cur = cur->next;
    }
}

/* 核心代码 */
#define MAX_SIZE 601

int getCount(LinkedList *link) {
    int deposit_tail_zero = 0; // 等待插入的0的数量
    int count = 0; // 插入次数

    while (link->size > 1) {
        // 取前三个数
        int g1 = removeFirst_LinkedList(link);
        int g2 = removeFirst_LinkedList(link);
        int g3 = removeFirst_LinkedList(link);

        // 状态: 0 x x
        // 含义是：第一个数为0，第二个、第三个数相同且不为0
        if (g1 == 0 && g2 != 0 && g2 == g3) {
            continue;
        }

        // 状态: x 0 x
        if (g2 == 0 && g1 != 0 && g1 == g3) {
            continue;
        }

        // 状态: x x 0
        if (g3 == 0 && g1 != 0 && g1 == g2) {
            continue;
        }

        // 状态: 0 0 x 和 状态: 0 x 0
        if (g1 == 0 && g2 == 0 || g1 == 0 && g3 == 0) {
            // 上面状态多了一个0, 我们需要相办法讲多出的0插入到需要的地方
            // 但是该把多出的0插入到哪里呢？
            // 如果deposit_tail_zero < 0,  则前面循环中，有借0动作，因此本轮多了一个0，可以借给之前轮次, 因此本轮多出的0不需要消耗插入次数
            if (deposit_tail_zero >= 0) {
                // 如果deposit_tail_zero >= 0, 则前面循环中，不需要借此轮多出的0，因此本轮多出的0要消耗一次插入次数，等待找到合适位置插入
                count++;
                addLast_LinkedList(link, g1); // 多出的0先记录到link尾部，原因是避免link元素数量不是3的倍数
            }

            // 等待插入的0数量+1
            deposit_tail_zero++;

            // g1被提取出去了， 剩下的两个数g2,g3重新头插获取
            addFirst_LinkedList(link, g3);
            addFirst_LinkedList(link, g2);
            continue;
        }

        // 状态: x 0 0
        if (g2 == 0 && g3 == 0) {
            // 逻辑和前面状态: 0 0 x 和 状态: 0 x 0一样
            if (deposit_tail_zero >= 0) {
                count++;
                addLast_LinkedList(link, g2);
            }
            deposit_tail_zero++;

            addFirst_LinkedList(link, g3);
            addFirst_LinkedList(link, g1);
            continue;
        }

        addFirst_LinkedList(link, g3);

        // 状态: 0 x y
        if (g1 == 0) {
            count++;
            removeEle(link, g2);
            continue;
        }

        // 状态: x 0 y
        if (g2 == 0) {
            count++;
            removeEle(link, g1);
            continue;
        }

        // 状态: x x y
        if (g1 == g2) {
            if (deposit_tail_zero > 0) {
                // 有等待插入得0,
                removeLast_LinkedList(link);
            } else {
                count++;
            }
            deposit_tail_zero--;
        } else {
            // 状态: x y z
            if (deposit_tail_zero > 0) {
                // 有等待插入的0
                removeLast_LinkedList(link);
                deposit_tail_zero--;

                // 等待插入0和开头x组合，则还需要一个x组的
                removeEle(link, g1);
                count++;
            } else {
                count++;
                addEle(link, g1);
            }

            addFirst_LinkedList(link, g2);
        }
    }

    return count;
}

int solution(int groups[], int n) {
    LinkedList *link = new_LinkedList();
    for (int i = 0; i < n; i++) {
        addLast_LinkedList(link, groups[i]);
    }

    LinkedList *link_reverse = new_LinkedList();
    for (int i = n - 1; i >= 0; i--) {
        addLast_LinkedList(link_reverse, groups[i]);
    }

    int cnt1 = getCount(link);
    int cnt2 = getCount(link_reverse);

    return (int) fmin(cnt1, cnt2);
}

int cmp(const void *a, const void *b) {
    return (*(int *) a) - (*(int *) b);
}

int main() {
    // nums = 1 8 9 7 4 2 5 6 3
    int nums[MAX_SIZE];
    int nums_size = 0;
    while (scanf("%d", &nums[nums_size++])) {
        if (getchar() != ' ') break;
    }

    // nums_sorted = 1 2 3 4 5 6 7 8 9
    int nums_sorted[MAX_SIZE];
    for (int i = 0; i < nums_size; i++) {
        nums_sorted[i] = nums[i];
    }
    qsort(nums_sorted, nums_size, sizeof(int), cmp);

    // 如果想要最后S最大，则 8 9 必须一组， 6 7 必须一组，4 5 必须一组，剩余1,2,3任意选哪一组都可以
    // 比如 1 8 9 一组, 4 2 5 一组, 6 3 7 一组， 可得最大S和为：8 + 4 + 6 = 18

    // 假设我们认为 8 9 是第三组，6 7 是第二组, 4 5 是第一组，1 2 3是第0组（第0组表示全适配
    // 那么讲nums[i] 映射为组号 groups[i]得规则如下
    int groups[MAX_SIZE];
    for (int i = 0; i < nums_size; i++) {

        int j = 0;
        for (; j < nums_size; j++) {
            if (nums_sorted[j] == nums[i]) break;
        }

        if (j < nums_size / 3) {
            // 对于处于nums_sorted数组前 n/3 个得元素都属于第0组
            groups[i] = 0;
        } else {
            // 对于处于nums_sorted数组后 n * 2/3 个元素，每两个元素一组，从第1组开始计数
            groups[i] = (j - nums_size / 3) / 2 + 1;
        }
    }

    printf("%d\n", solution(groups, nums_size));

    return 0;
}