// Runtime: 2 ms
// Memory Usage: 42 MB
class Solution {
  List<Integer> removeDigitIndexs = new ArrayList<>();
  public String removeDigit(String number, char digit) {
    for (int i = 0; i < number.toCharArray().length; i ++) {
      if (Objects.equals(number.charAt(i), digit)) {
        removeDigitIndexs.add(i);
      }
    }


    Integer maxValueIndex = removeDigitIndexs.get(0);
    for (Integer removeDigitIndex : removeDigitIndexs) {
      if (removeDigitIndex + 1 >= number.length()) {
        maxValueIndex = removeDigitIndex;
        break;
      }

      if (number.charAt(removeDigitIndex) < number.charAt(removeDigitIndex + 1)) {
        maxValueIndex = removeDigitIndex;
        break;
      }
      maxValueIndex = removeDigitIndex;
    }

    return subNumber(number, maxValueIndex);
  }

  public String subNumber(String number, Integer index) {
    StringBuilder result = new StringBuilder();
    for (int i = 0 ; i < number.length(); i++) {
      if (i == index) {
        continue;
      }

      result.append(number.charAt(i));
    }

    return result.toString();
  }
}
