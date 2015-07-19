class Test{
	public static void main(String[] args){
		ClassLoader classloader=Thread.currentThread().getContextClassLoader();
		String reosurceName="com/alibaba/simpleEL/dialect/tiny/TinyELEvalService.class";
		Enumeration<URL> urls=classloader.getResources(reosurceName);
		while(urls.hasMoreElements()){
			URL url=urls.nextElement();
			System.out.println(url);
		}
	}
}