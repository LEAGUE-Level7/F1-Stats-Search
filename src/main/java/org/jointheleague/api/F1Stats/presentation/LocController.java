package org.jointheleague.api.F1Stats.presentation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jointheleague.api.F1Stats.service.LocService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocController {

    private final LocService locService;

    public LocController(LocService locService) {
        this.locService = locService;
    }

    @GetMapping("/searchLocResults")
    @ApiOperation(value = "Shows Constructors for the given year",
//            notes = "Response may include multiple Result values.",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Result(s) found"),
            @ApiResponse(code = 404, message = "That's not good (bad year?)")
    })
    public String getResults(@RequestParam(value="year") String year){
        return locService.getResults(year);
    }

}