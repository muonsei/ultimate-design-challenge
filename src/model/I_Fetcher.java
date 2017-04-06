package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface I_Fetcher {
	ArrayList<?> getAll();
	Object getBySearch(String keyword);
	Object toObject(ResultSet rs) throws SQLException;
}
