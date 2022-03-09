package resilience.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient  {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //service start
    public void connect() {
        System.out.println("connect: url = " + url);
    }

    public void call(String message) {
        System.out.println("call: url = " + url + ", message = " + message);
    }

    //service end
    public void disconnect() {
        System.out.println("disconnect: url = " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("hello message!!");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("hello message!!");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
