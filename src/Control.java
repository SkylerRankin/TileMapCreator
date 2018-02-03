
public class Control {
    
    Model m;
    View v;
    
    public Control(Model m, View v) {
        this.m = m;
        this.v = v;
        v.setVisible(true);
    }
    
    public static void main(String[] args) {
        Control c = new Control(new Model(), new View());
    }

}
