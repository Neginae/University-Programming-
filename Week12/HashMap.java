class HashMap {

     // What fields we need?
     private String[] keys;
     private int[] values;
     final int capacity;

     HashMap(int capacity) {
          if (capacity < 0) {
               throw new IllegalArgumentException();
          }
          this.capacity = capacity;
          this.keys = new String[capacity];
          this.values = new int[capacity];
     }

     void put(String key, int value) {
          if (key == null) {
               throw new NullPointerException();
          }

          int index = Math.abs(key.hashCode() % capacity);
          if (keys[index] == null) {
               keys[index] = key;
               values[index] = value;
          }
          else if (keys[index].equals(key)) {
               values[index] = value;
          } else {
               keys[index] = key;
               values[index] = value;
          }
     }

     @Override
     public String toString() {
          if (keys == null) {
               return "{}";
          }

          String result = "{";

          for (int i = 0; i < keys.length; i++) {
               if (keys[i] != null) {
                    result += keys[i] + ":" + values[i] + ", ";
               }
          }
          result += "}";
          return result;
     }

     boolean contains(String key) {
          if (key == null) {
               throw new NullPointerException();
          }

          int index = Math.abs(key.hashCode() % capacity);
          if (keys[index] != null && keys[index].equals(key)) {
               return true;
          }
          return false;
     }

     int get(String key) {
          if (key == null) {
               throw new NullPointerException();
          }

          int index = Math.abs(key.hashCode() % capacity);
          if (keys[index] != null && keys[index].equals(key)) {
               return values[index];
          }
          throw new java.util.NoSuchElementException();
     }
}
