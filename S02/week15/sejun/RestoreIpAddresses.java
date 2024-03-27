// 5ms, 43.06MB
class Solution {
    private final Integer MAX_IP_ADDRESS = 255;
    private final List<List<String>> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        for (int index = 1; index <= 3; index++) {
            List<String> temp = new ArrayList<>();
            makeIpAddrSubSet(s, 0, index, temp);
        }

        return result.stream()
                .map(r -> String.join("", r))
                .collect(Collectors.toList());
    }

    public void makeIpAddrSubSet(String ip, int startIndex, int index, List<String> ipList) {
        if (ipList.size() == 4) {
            if (ipSize(ipList) == ip.length()) {
                result.add(ipList);
            }
            return;
        }

        if (index > ip.length()) {
            return;
        }

        if (!checkIpBoundary(ip.substring(startIndex, index))) {
            return;
        }

        List<String> temp = new ArrayList<>(ipList);
        temp.add(ip.substring(startIndex, index));

        for (int subIndex = index+1; subIndex <= index + 3 && subIndex <= ip.length()+1; subIndex++) {
            makeIpAddrSubSet(ip, index, subIndex, temp);
        }
    }

    public boolean checkIpBoundary(String ipSubSet) {
        if (ipSubSet.length() == 1) {
            return true;
        }

        if ("0".equals(ipSubSet.substring(0, 1))) {
            return false;
        }

        return (0 <= Integer.parseInt(ipSubSet) && Integer.parseInt(ipSubSet) <= 255);
    }

    public int ipSize(List<String> ipList) {
        int size = 0;
        for (String ip : ipList) {
            size += ip.length();
        }

        return size;
    }
}
