// Runtime 82ms Beats 5.80% of users with Java
// Memory 45.49MB Beats 5.15% of users with Java
class Solution {
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
}
