package com.kapok.service.discovery;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kapok.service.store.RDF;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpCommandUtil {

    private static final int SUCCESS_CODE = 200;

    private static final String SAVE_URL = "/saveRdfs";

    private static final String REGISTER_WORKER_URL = "/registerWorker";

    public static void sendSaveRdfsCommand(Node node, RDF rdf) {
        String url = "http://" + node.getHost() + ":" + node.getPort() + SAVE_URL;
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            StringEntity entity = new UrlEncodedFormEntity(new ArrayList<>(), "UTF-8");
            post.setEntity(entity);
            post.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
            post.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
            response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (SUCCESS_CODE == statusCode) {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                try {
                    jsonObject = JSONObject.parseObject(result);
                    System.out.println(jsonObject);
                    return;
                } catch (Exception e) {
                    return;
                }
            } else {
                System.out.println(String.format("HttpClientService-line: %d, errorMsg：%s", 146, "POST请求失败！"));
            }
        } catch (Exception e) {
            System.out.println(String.format("HttpClientService-line: %d, Exception：%s", 149, e));
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                // ignore this exception
            }
        }
    }

    public static void sendReadRdfsCommand(Node node) {
        // TODO: implement this method
    }

    /**
     * This method is for worker to register its information to coordinator
     * @param coordinatorNode
     * @param workerNode
     */
    public static void sendRegisterWorkerCommand(Node coordinatorNode, Node workerNode) {
        String url = "http://" + coordinatorNode.getHost() + ":" + coordinatorNode.getPort() + REGISTER_WORKER_URL;
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            JSONArray requestJson = new JSONArray();
            requestJson.add(workerNode);
            StringEntity entity = new StringEntity(requestJson.toJSONString());
            post.setEntity(entity);
            post.setHeader(new BasicHeader("Content-Type", "application/json;charset=utf-8"));
            response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (SUCCESS_CODE == statusCode) {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                try {
                    jsonObject = JSONObject.parseObject(result);
                    System.out.println(jsonObject);
                    return;
                } catch (Exception e) {
                    return;
                }
            } else {
                System.out.println(String.format("HttpClientService-line: %d, errorMsg：%s", 146, "POST请求失败！"));
            }
        } catch (Exception e) {
            System.out.println(String.format("HttpClientService-line: %d, Exception：%s", 149, e));
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                // ignore this exception
            }
        }
    }

}
