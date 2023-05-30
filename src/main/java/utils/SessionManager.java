/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author iamdveloper
 */

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager {
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000; // 30 minutes
    private static final Map<String, Session> sessions = new HashMap<>();

    public static String createSession(String username) {
        String sessionId = generateSessionId();
        Session session = new Session(sessionId, username);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public static boolean isValidSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isValid()) {
            session.updateLastAccessedTime();
            return true;
        }
        return false;
    }

    public static String getUsername(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            return session.getUsername();
        }
        return null;
    }

    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private static String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    private static class Session {
        private final String sessionId;
        private final String username;
        private long lastAccessedTime;

        public Session(String sessionId, String username) {
            this.sessionId = sessionId;
            this.username = username;
            this.lastAccessedTime = System.currentTimeMillis();
        }

        public boolean isValid() {
            return (System.currentTimeMillis() - lastAccessedTime) <= SESSION_TIMEOUT;
        }

        public void updateLastAccessedTime() {
            lastAccessedTime = System.currentTimeMillis();
        }

        public String getUsername() {
            return username;
        }
    }
}

