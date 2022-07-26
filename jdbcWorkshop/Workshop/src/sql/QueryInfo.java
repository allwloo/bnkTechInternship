package sql;

public interface QueryInfo {
	String queryInsert = "INSERT INTO customer VALUES(?,?,?)";
	String querySelect = "SELECT ssn, name, address FROM customer";
}
