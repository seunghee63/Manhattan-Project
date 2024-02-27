class Solution {
    // Runtime 82ms Beats 5.80% of users with Java
    // Memory 45.49MB Beats 5.15% of users with Java
    public String maximumOddBinaryNumber(String s) {
        List<String> bitList = s.chars()
            .mapToObj(c -> c - '0')
            .peek(System.out::println)
            .sorted(Comparator.reverseOrder())
            .map(String::valueOf)
            .collect(Collectors.toList());

        String removed = bitList.remove(0);
        bitList.add(removed);

        return String.join("", bitList);
    }

    // Runtime8ms Beats 11.74% of users with Java
    // Memory 44.34MB Beats 25.46% of users with Java
    public String maximumOddBinaryNumber_v2(String s) {
        List<String> result = new ArrayList<>();
        s.chars()
            .forEach(c -> {
                if (c == '0') {
                    result.add("0");
                }
                if (c == '1') {
                    result.add(0, "1");
                }
            });

        String removed = result.remove(0);
        result.add(removed);

        return String.join("", result);
    }
}
