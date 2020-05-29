package com.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private AuthClient authClient;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    @Override
    public Object run() {


        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String authenticationHeader = request.getHeader("Authorization");
        if (authenticationHeader == null){
            System.out.println( "No header present");
            return null;
        }

        String jwtToken = authenticationHeader.replace("Bearer ", "");
        System.out.println(jwtToken);

        try {
            boolean valid = authClient.verify(jwtToken);
            System.out.println(valid);
            System.out.println( "cao cao");
            // redirection (?) -> not needed I fixed it... :)
        } catch (Exception e) {
            setFailedRequest("Invalid token", 403);
        }

        return null;

    }


}
