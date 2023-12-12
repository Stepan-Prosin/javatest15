public class ShopRepository {
    private Product[] products = new Product[0];


    public void aDD(Product product) {
        products = addToArray(products, product);
    }

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        System.arraycopy(current, 0, tmp, 0, current.length);
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /**
     * Метод добавления товара в репозиторий
     *
     * @param product — добавляемый товар
     */
    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void remove(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int a = products.length - 1;
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int Id) {
        Product result; // массив для ответа
        for (Product product : products) { // перебираем все задачи
            if (product.equals(Id)) { // если задача подходит под запрос
                result = product; // добавляем её в массив ответа
            }
        }
        return null;
    }
}