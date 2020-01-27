package com.company.model;

public class ConnectionToServer {

    private int session;
    private long timestamp;
    private String ip;

    public ConnectionToServer() {
    }

    public ConnectionToServer(int session, long timestamp, String ip) {
        this.session = session;
        this.timestamp = timestamp;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return timestamp + " " + session + " " + ip;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
