package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface I_Fetcher {
	ArrayList<?> getAll();
	ArrayList<?> getSingle();
	Object toObject(ResultSet rs) throws SQLException;
}
