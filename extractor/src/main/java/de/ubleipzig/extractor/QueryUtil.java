package de.ubleipzig.extractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryUtil {

    static String getQuery(final String qname, final String replaceNode) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(qname);
        String out = readFile(is);
        return replaceNode(out, replaceNode);
    }

    private static String replaceNode(String query, String node) {
        Pattern p = Pattern.compile("\\?node");
        Matcher m = p.matcher(query);
        StringBuffer sb = new StringBuffer(query.length());
        while (m.find()) {
            m.appendReplacement(sb, Matcher.quoteReplacement(node));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static String readFile(InputStream in) throws IOException {
        StringBuilder inobj = new StringBuilder();
        try (BufferedReader buf = new BufferedReader(
                new InputStreamReader(in, "UTF-8"))) {
            String line;
            while ((line = buf.readLine()) != null) {
                inobj.append(line).append("\n");
            }
        }
        return inobj.toString();
    }
}