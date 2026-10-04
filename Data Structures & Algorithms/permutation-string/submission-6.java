class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            if (s1.indexOf(s2.charAt(i)) != -1) {
                if (checkAnagram(s1, s2.substring(i, i + s1.length()))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkAnagram(String s1, String s2) {
        System.out.println(s1 + " " + s2);
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s1.toCharArray()) counts.merge(c, 1, Integer::sum);
        for (char c : s2.toCharArray()) {
            if (counts.merge(c, -1, Integer::sum) < 0) return false;
        }

        return true;
    }
}
