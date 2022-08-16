package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//클랑언트에서 들어오는 모든ㅇ ㅛ청을 EncodingFilter가 받는다.
@WebFilter(value= {"/*"})
public class EncodingFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//양방향 한글처리...
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//서버상의 다음 컴포넌트에게 계속 한글처리 필터링한 작업이 연결되도록 하는 작업.
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
