package project1CS2430;

import java.util.Arrays;
import java.util.Objects;

public class SortReportData implements Comparable<SortReportData> {
	public String sortMethod;
	public int[] arry;
	public int count;

	public SortReportData(String sortMethod, int[] arry, int count) {
		this.sortMethod = sortMethod;
		this.arry = arry;
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SortReportData))
			return false;
		SortReportData other = (SortReportData) obj;
		return Arrays.equals(arry, other.arry) && count == other.count && Objects.equals(sortMethod, other.sortMethod);
	}

	@Override
	public int compareTo(SortReportData o) {
		return this.count - o.count;
	}
	
	
}