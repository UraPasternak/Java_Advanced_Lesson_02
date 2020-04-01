package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		List<Reader> readers = new ArrayList<>();
		readers.add(new Reader("Vasa", 30, "vasa@gmail.com"));
		readers.add(new Reader("Ігор", 24, "igor@gmail.com"));
		readers.add(new Reader("Юра", 27, "ura@gmail.com"));
		readers.add(new Reader("Олена", 36, "olena@gmail.com"));
		readers.add(new Reader("Леся", 18, "lesa@gmail.com"));
		
		List<Zhurnal> zhurnals = new ArrayList<>();
		zhurnals.add(new Zhurnal("Мурзілка", 35.50));
		zhurnals.add(new Zhurnal("NEW-USS", 50.70));
		
		ReaderDAO readerdao = new ReaderDAO(ConnectionUtil.openConnection());
		ZhurnalDAO zhurnaldao = new ZhurnalDAO(ConnectionUtil.openConnection());
		readers.forEach(reader->{
			try {
				readerdao.insert(reader);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}); 
		
		readerdao.readAll().forEach(System.out::println);
		System.out.println("=============================================================\n");
		System.out.println(readerdao.read(4).toString());
		System.out.println("=============================================================\n");
		readerdao.update(new Reader(5,"Lesia",20,"lesia@gmail.com"));
		System.out.println(readerdao.read(5).toString());
		System.out.println("=============================================================\n");
		readerdao.delete(5);
		readerdao.readAll().forEach(System.out::println);
		System.out.println("=============================================================\n");
		
		zhurnals.forEach(zhurnal->{
			try {
				zhurnaldao.insert(zhurnal);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		zhurnaldao.readAll().forEach(System.out::println);
		System.out.println("=============================================================\n");
		System.out.println(zhurnaldao.read(2).toString());
		System.out.println("=============================================================\n");
		zhurnaldao.update(new Zhurnal(2,"Lesia",20.80));
		System.out.println(zhurnaldao.read(2).toString());
		System.out.println("=============================================================\n");
		zhurnaldao.delete(2);
		zhurnaldao.readAll().forEach(System.out::println);
		System.out.println("=============================================================\n");

	}

}
