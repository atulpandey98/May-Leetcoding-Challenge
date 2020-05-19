// Online Stock Span

class StockSpanner {

    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        if(list.size() == 0) {
           list.add(price);
            return 1;
        }
        int index = list.size() - 1;
        int count = 1;
        while(index >= 0 && list.get(index) <= price) {
            count++;
            index--;
        }
        list.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
