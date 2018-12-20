public class Mutex {
    private boolean locked = false;
    public void lock() {
        while (locked)
            try {Thread.sleep(4);}catch(Exception ex){}
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }
}
