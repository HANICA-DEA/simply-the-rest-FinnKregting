package nl.han.dea.services.mappers;

import nl.han.dea.services.exceptions.IdAlreadyInUseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IdAlreadyInUseExceptionMapper implements ExceptionMapper <IdAlreadyInUseException> {
    @Override
    public Response toResponse(IdAlreadyInUseException e) {
        return Response.status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
