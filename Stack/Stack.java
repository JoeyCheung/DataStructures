public interface Stack <T> {
    public boolean empty();
    
    public void push(T d) throws Exception;
    
    public T pop() throws Exception;
    
    public int size();
    
}
