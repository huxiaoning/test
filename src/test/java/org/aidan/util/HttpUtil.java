package org.aidan.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    private static final Logger logger = LoggerFactory
            .getLogger(HttpUtil.class);

    public static String post(String url, Map<String, Object> params, Map<String, String> headers) {
        String resultJson = "";
        CloseableHttpClient httpclient = getHttpClientInstance();
        HttpPost httppost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httppost.setConfig(requestConfig);
        setRequestHeaders(httppost, headers);
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(JSON.toJSONString(params), ENCODING);
            entity.setContentEncoding(ENCODING);
            entity.setContentType(CONTENTTYPE_JSON);
            httppost.setEntity(entity);
            response = httpclient.execute(httppost);
            HttpEntity result = response.getEntity();
            resultJson = EntityUtils.toString(result, ENCODING);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭连接,释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return resultJson;
    }

    public static String get(String url, Map<String, Object> params, Map<String, String> headers) {
        String resultJson = "";
        if (params != null && params.size() > 0) {
            url += "?";
            Set<Map.Entry<String, Object>> entries = params.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                url += (key + "=" + value + "&");
            }
        }
        CloseableHttpClient httpclient = getHttpClientInstance();
        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpGet.setConfig(requestConfig);
        setRequestHeaders(httpGet, headers);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            HttpEntity result = response.getEntity();
            resultJson = EntityUtils.toString(result, ENCODING);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭连接,释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return resultJson;
    }

    public static String put(String url, Map<String, Object> params, Map<String, String> headers) {
        String resultJson = "";
        CloseableHttpClient httpclient = getHttpClientInstance();
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPut.setConfig(requestConfig);
        setRequestHeaders(httpPut, headers);
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(JSON.toJSONString(params), ENCODING);
            entity.setContentEncoding(ENCODING);
            entity.setContentType(CONTENTTYPE_JSON);
            httpPut.setEntity(entity);
            response = httpclient.execute(httpPut);
            HttpEntity result = response.getEntity();
            resultJson = EntityUtils.toString(result, ENCODING);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭连接,释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return resultJson;
    }

    public static String delete(String url, Map<String, Object> params, Map<String, String> headers) {
        String resultJson = "";
        if (params != null && params.size() > 0) {
            url += "?";
            Set<Map.Entry<String, Object>> entries = params.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                url += (key + "=" + value + "&");
            }
        }
        CloseableHttpClient httpclient = getHttpClientInstance();
        HttpDelete httpDelete = new HttpDelete(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpDelete.setConfig(requestConfig);
        setRequestHeaders(httpDelete, headers);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpDelete);
            HttpEntity result = response.getEntity();
            resultJson = EntityUtils.toString(result, ENCODING);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭连接,释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return resultJson;
    }


    public static final String ENCODING = "UTF-8";
    public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CONTENTTYPE_PARAM = "application/x-www-form-urlencoded";

    private static CloseableHttpClient httpClientInstance = null;
    private static HttpClientConnectionManager httpClientConnectionManagerInstance = null;

    private static CloseableHttpClient getHttpClientInstance() {
        if (httpClientInstance == null) {
            synchronized (HttpUtil.class) {
                if (httpClientInstance == null) {
                    httpClientInstance = getHttpClient();
                }
            }
        }
        return httpClientInstance;
    }

    private static HttpClientConnectionManager getHttpClientConnectionManagerInstance() {
        if (httpClientConnectionManagerInstance == null) {
            synchronized (HttpUtil.class) {
                if (httpClientConnectionManagerInstance == null) {
                    httpClientConnectionManagerInstance = getHttpClientConnectionManager();
                }
            }
        }
        return httpClientConnectionManagerInstance;
    }

    private static HttpClientConnectionManager getHttpClientConnectionManager() {
        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.conn.ssl.SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {
                    return true;
                }
            }).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // don't check Hostnames, either.
        // 		-- use SSLConnectionSocketFactory.getDefaultHostnameVerifier(), if you don't want to weaken
        X509HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        // here's the special part:
        // 		-- need to create an SSL Socket Factory, to use our weakened "trust strategy";
        //		-- and create a Registry, to register it.
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();
        // now, we create connection-manager using our Registry.
        // 		-- allows multi-threaded use
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        manager.setMaxTotal(50);
        return manager;
    }

    private static CloseableHttpClient getHttpClient() {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(3000)
                .setConnectTimeout(3000)
                .setConnectionRequestTimeout(3000)
                .setStaleConnectionCheckEnabled(true)
                .build();
        return HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .setConnectionManager(getHttpClientConnectionManagerInstance())
                .build();
    }

    private static void setRequestHeaders(HttpRequestBase request, Map<String, String> headers) {
        if (headers != null && headers.size() > 0) {
            Set<Map.Entry<String, String>> entries = headers.entrySet();
            Iterator<Map.Entry<String, String>> it = entries.iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> header = it.next();
                request.addHeader(header.getKey(), header.getValue());
            }
        }
    }


    public static String post(String url, String json, Map<String, String> headers) {
        String resultJson = "";
        CloseableHttpClient httpclient = getHttpClientInstance();
        HttpPost httppost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httppost.setConfig(requestConfig);
        setRequestHeaders(httppost, headers);
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(json, ENCODING);
            entity.setContentEncoding(ENCODING);
            entity.setContentType(CONTENTTYPE_JSON);
            httppost.setEntity(entity);
            response = httpclient.execute(httppost);
            HttpEntity result = response.getEntity();
            resultJson = EntityUtils.toString(result, ENCODING);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭连接,释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return resultJson;
    }
}
