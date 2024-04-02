//3ms Memory 41.14MB

class Solution {
  public String reverseWords(String s) {
    List<String> subList = subWords(s);

    StringBuilder result = new StringBuilder();

    result.append(subList.get(subList.size() - 1));
    for (int i = subList.size() - 2; i >= 0 ; i--) {
      result.append(" ");
      result.append(subList.get(i));
    }

    return result.toString();
  }

  public List<String> subWords(String s) {
    int i = 0;
    List<String> result = new ArrayList<>();
    while(i <= s.length() - 1) {
      StringBuilder mid = new StringBuilder();
      while (i <= s.length() - 1 && s.toCharArray()[i] != ' ') {
        mid.append(s.toCharArray()[i]);
        i++;
      }
      i++;
      if(!mid.toString().equals("")) {
        result.add(mid.toString());
      }
    }

    return result;
  }
}
