class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (true) {
            count++;
            List<String> polledWords = new ArrayList<>();
            while (!q.isEmpty()) {
                String node = q.poll();
                if (node.equals(endWord)) return count;
                polledWords.add(node);
            }

            polledWords.forEach(polled -> {
                List<String> neighbors = transformableTo(polled, wordList);
                neighbors.forEach(word -> {
                    q.offer(word);
                    wordList.remove(word);
                });
            });

            if (q.isEmpty()) return 0;
        }

    }

    
    

    private List<String> transformableTo(String source, List<String> words) {
        List<String> neighbors = new ArrayList<>();
        words.forEach(word -> {
            if (oneLetterApart(source, word)) {
                neighbors.add(word);
            }
        });

        return neighbors;
    }

    private boolean oneLetterApart(String source, String dest) {
    if (source.length() != dest.length()) return false;

    int diff = 0;
    for (int i = 0; i < source.length(); i++) {
        if (source.charAt(i) != dest.charAt(i)) {
            diff++;
            if (diff > 1) return false;   // stop early, already too many
        }
    }
    return diff == 1;
}
}
