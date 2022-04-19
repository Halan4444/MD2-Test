package product.services.Payment;

import data.Path;
import product.model.Payment;
import product.config.CSVUtils;
import product.services.Product.ProductService;

import java.util.ArrayList;
import java.util.List;

public class PaymentService extends ProductService implements IPaymentService {
    List<Payment> paymentList = new ArrayList<>();
    public static  String PATH_PAYMENT = Path.PATH + "payment.csv";
    public static String path = PATH_PAYMENT;

    @Override
    public List<Payment> getPayment() {
        List<Payment> newPaymentList = new ArrayList<>();
        List<String> reads = CSVUtils.read(path);
        for (String read : reads) {
            newPaymentList.add(new Payment(read));
        }
        return paymentList = newPaymentList;
    }

    @Override
    public void  add(List <Payment> list) {
        getPayment();
        for (Payment p:list) {
            paymentList.add(p);
        }
        CSVUtils.write(path, paymentList);
    }

    @Override
    public void recheck(int id, Payment updatePayment) {
        getPayment();
        for (int i = 0; i < paymentList.size(); i++) {
            if (paymentList.get(i).getId() == id) {
                paymentList.set(i, updatePayment);
                CSVUtils.write(path, paymentList);
            }
        }
    }

    public Payment findPaymentID(int id){
        getPayment();
        for (Payment payment : paymentList) {
            if (payment.getId() == id){
                return payment;
            }
        }
        System.out.println("\t\t\t\tKhông có sản phẩm này");
        return null;
    }

    public long showTotal (){
        getPayment();
        long a = 0;
        for (Payment p:paymentList) {
            long x = p.getRevenue();
            a+=x;
        }
        return a;
    }

}
