import ChainedHash.ChainedHashTableDemo;
import MapAndSet.Entry;
import MapAndSet.Map;
import MapAndSet.SetAdapterMap;

public class HashTableDemo {
   public static void main(String args[]) {
      Entry<String, String> flag =
            new Entry<String, String>("FLAG", null);
      OpenHashTable<Entry<String, String>> table =
            new OpenHashTable<Entry<String, String>>(4, flag);
      Map<String, String> m = new SetAdapterMap<>(table);
      ChainedHashTableDemo.testMap(m);
   }
}
