class DoublyLL{
    String val;
    DoublyLL next;
    DoublyLL prev;

    DoublyLL(String val){
        this.val = val;
    }
}
class BrowserHistory {
    DoublyLL cache;
    DoublyLL temp;
    public BrowserHistory(String homepage) {
        cache = new DoublyLL(homepage);
        temp = cache;
    }

    public void visit(String url) {
        DoublyLL currPage = new DoublyLL(url);
        currPage.next = null;
        temp.next = currPage;
        currPage.prev = temp;

        while(temp.next != null){
            temp = temp.next;
        }
    }
    
    public String back(int steps) {
        while(steps-- > 0 && temp != null && temp.prev != null){
            temp = temp.prev;
        }

        return temp.val;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && temp != null && temp.next != null){
            temp = temp.next;
        }

        return temp.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */