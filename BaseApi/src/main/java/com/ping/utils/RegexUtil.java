package com.ping.utils;

import java.util.regex.Pattern;

/**
 * ========================
 * module_name:[]
 * module_desc:
 *
 * @author: dp
 * @date: 2023/4/21
 * @since: 1.0
 * ========================
 */
public class RegexUtil {

    /**
     * IPV4正则
     */
    private static final String REGEX_IPV4 = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";

    /**
     * IPV6正则
     */
    private static final String REGEX_IPV6 = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";

    /**
     * IPV6正则（缩写形式，连续的0位用双冒号代替），比如：连续的0位用双冒号代替
     */
    private static final String REGEX_IPV6_ABBR = "^(([0-9a-fA-F]{1,4}:){6}|(:[0-9a-fA-F]{1,4}){1,7})((:[0-9a-fA-F]{1,4}){0,6}|::[0-9a-fA-F]{1,4})$";

    /**
     * 域名正则
     */
    private static final String REGEX_DOMAIN = "^(?=.{1,255}$)([a-zA-Z0-9_-]+|[^\\u0000-\\u007F]+)(\\.[a-zA-Z0-9_-]+|[^\\u0000-\\u007F]+)*\\.[a-zA-Z]{2,}$";

    /**
     * 端口正则
     */
    private static final String REGEX_PORT = "^[1-9][0-9]{0,3}$|^0$";

    private static final Pattern PATTERN_IPV4 = Pattern.compile(REGEX_IPV4);
    private static final Pattern PATTERN_IPV6 = Pattern.compile(REGEX_IPV6);
    private static final Pattern PATTERN_IPV6_ABBR = Pattern.compile(REGEX_IPV6_ABBR);
    private static final Pattern PATTERN_DOMAIN = Pattern.compile(REGEX_DOMAIN);
    private static final Pattern PATTERN_PORT = Pattern.compile(REGEX_PORT);


    /**
     * 校验是否是有效的ipv4地址
     *
     * @param ipv4Address IPV4地址
     * @return true-有效的ipv4地址，false-无效的ipv4地址
     * @since 1.0
     **/
    public static boolean isValidIpv4(String ipv4Address) {
        return PATTERN_IPV4.matcher(ipv4Address).matches();
    }

    /**
     * 校验是否是有效的ipv6地址
     *
     * @param Ipv6Address IPV6地址
     * @return true-有效的ipv6地址，false-无效的ipv6地址
     * @since 1.0
     **/
    public static boolean isValidIpv6(String Ipv6Address) {
        boolean matches = PATTERN_IPV6.matcher(Ipv6Address).matches();
        if (!matches) {
            matches = PATTERN_IPV6_ABBR.matcher(Ipv6Address).matches();
        }
        return matches;
    }

    /**
     * 校验是否是有效的域名
     *
     * @param domain 域名
     * @return true-有效的域名，false-无效的域名
     * @since 1.0
     **/
    public static boolean isValidDomain(String domain) {
        return PATTERN_DOMAIN.matcher(domain).matches();
    }

    /**
     * 校验是否是有效的端口
     *
     * @param port 端口
     * @return true-有效的端口，false-无效的端口地址
     * @since 1.0  
     **/
    public static boolean isValidPort(String port) {
        return PATTERN_PORT.matcher(port).matches();
    }
}
