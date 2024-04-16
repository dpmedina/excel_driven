public class TestcaseObj {

	String testcase;
	String data1;
	String data2;
	String data3;

	public String getTestcase() {
		return testcase;
	}

	public void setTestcase(String testcase) {
		this.testcase = testcase;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	public TestcaseObj() {
	}

	public TestcaseObj(String testcase, String data1, String data2, String data3) {
		super();
		this.testcase = testcase;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}

	@Override
	public String toString() {
		return "TestcaseObj [testcase=" + testcase + ", data1=" + data1 + ", data2=" + data2 + ", data3=" + data3 + "]";
	}

}
