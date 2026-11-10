package edu.imi.ir.eduimiws.models.response;

import edu.imi.ir.eduimiws.exceptions.v2.RaiseError;
import lombok.Builder;

@Builder
public record Response<T>(T responseDto, RaiseError raiseError) {
}
