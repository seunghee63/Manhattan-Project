// 5ms Beats 52.70% of users with Java
// 43.37MB Beats 46.70% of users with Java
class Solution {
    private static final String CURRENT_DIR = ".";
    private static final String UP_DIR = "..";
    private static final String EMPTY = "";
    private static final String SLASH = "/";
    public String simplifyPath(String path) {
        String[] pathArr = path.split(SLASH);
        
        List<String> result = new ArrayList<>();
        for (String s : pathArr) {
            if (CURRENT_DIR.equals(s)) {
                continue;
            }

            if (UP_DIR.equals(s)) {
                if (!result.isEmpty()) {
                    result.remove(result.size() - 1);
                }
                continue;
            }

            if (EMPTY.equals(s)) {
                continue;
            }

            result.add(s);
        }

        return SLASH + String.join("/", result);
    }
}
