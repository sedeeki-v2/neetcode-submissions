class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.get(key) == null) {
            map.put(key, new TreeMap<>());
        } 

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (map.get(key) == null) return "";
        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
