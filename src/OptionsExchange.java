import java.util.ArrayList;
import java.util.List;

public class OptionsExchange {
    private List<String> from = new ArrayList<>();
    private List<String> to = new ArrayList<>();
    private int limit;

    public String getFrom(int i) {
        return from.get(i);
    }

    public String getTo(int i) {
        return to.get(i);
    }

    public int getLimit() {
        return limit;
    }

    public OptionsExchange(){
        String[] codes = {"ARS","BRL","COP"};

        for (int i = 0; i < codes.length ; i ++) {
            this.from.add("USD");
            this.to.add(codes[i]);
            this.from.add(codes[i]);
            this.to.add("USD");
        }

        this.limit = (codes.length * 2);
    }
}
