// 3ms Memory 41.14MB

public boolean isSubsequence(String s, String t) {
  Queue<Character> q = new LinkedList<>();
  for (Character c : s.toCharArray()) {
    q.add(c);
  }

  for (Character c : t.toCharArray()) {
    if (!q.isEmpty() && Objects.equals(c, q.peek())) {
      q.poll();
    }
  }

  return q.isEmpty();
}
