package cashMachine.entities;

public class Item {
    public long id;
    public String name;
    public float weight;
    public float price;

    public Item(long id, String name, float weight, float price) throws Exception {
        //todo количество на складе
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public Item(String name, float weight, float price) throws Exception {
        if (weight<0 & price <=0){
            throw new Exception("Incorrect values for price or weight");
        }

        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String toStringQuery(){
        StringBuilder res = new StringBuilder("'"+this.name+"'");
        res.append(',').append(weight);
        res.append(',').append(price);
        return res.toString();
    }
}
