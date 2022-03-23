package test;

import java.util.Map;

import dao.DocotsubuDAO;
import model.Mutter;

public class TestDao {
	public static void main(String[] args) {
		DocotsubuDAO dao = new DocotsubuDAO();
		Map<String,Mutter> mList = dao.toMutterAll();
		mList.entrySet().forEach(System.out::println);
	}
}
