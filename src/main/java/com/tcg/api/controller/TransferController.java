package com.tcg.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.tcg.transferprovider.service.TransferService;
import com.tcg.userprovider.entity.ReturnData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/***
 * 
 * @author 14861*@date 2020/5/21
 */
@Controller
@RequestMapping("/transfer")
@Api(tags = "图片处理接口")
public class TransferController {

    @Reference(version = "1.0.0")
    TransferService transferService;

    @ApiIgnore
    private ReturnData getReturnData(byte[] bytes) {
        ReturnData returnData = new ReturnData();
        if (bytes == null) {
            returnData.setCode(1);
            returnData.setMessage("transfer failed");
        } else {
            returnData.setCode(0);
            returnData.setMessage("transfer success");
            returnData.setData(bytes);
        }
        return returnData;
    }

    @ResponseBody
    @PostMapping(value = "/candy")
    @ApiOperation(value = "candy风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String candy(@RequestParam("uploadImage") MultipartFile uploadImage) throws IOException {

        byte[] fileBytes = null;
        try {
            fileBytes = transferService.candy(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);

        String result = JSON.toJSONString(returnData);
        // JSONObject jsonObject = JSON.parseObject(result);
        // byte[] imageBytes = jsonObject.getBytes("data");
        // File newFile = new File("images/" + "out1.jpg");
        // FileOutputStream fos = new FileOutputStream(newFile);
        // BufferedOutputStream bos = new BufferedOutputStream(fos);
        // bos.write(imageBytes);

        return result;
    }

    @ResponseBody
    @PostMapping("/composition")
    @ApiOperation(value = "composition风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String composition(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.composition(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/feathers")
    @ApiOperation(value = "feathers风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String feathers(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.feathers(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/laMuse")
    @ApiOperation(value = "la_muse风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String laMuse(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.laMuse(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/mosaic")
    @ApiOperation(value = "mosaic风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String mosaic(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.mosaic(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/starryNight")
    @ApiOperation(value = "starry_night风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String starryNight(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.starryNight(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/theScream")
    @ApiOperation(value = "the_scream风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String theScream(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.theScream(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/theWave")
    @ApiOperation(value = "the_wave风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String theWave(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.theWave(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/udnie")
    @ApiOperation(value = "udnie风格", notes = "(code,message)\n(0,\"transfer success\")\n(1,\"transfer failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "uploadImage", value = "图片文件", required = true, dataType = "__file")})
    public String udnie(@RequestParam("uploadImage") MultipartFile uploadImage) {
        byte[] fileBytes = null;
        try {
            fileBytes = transferService.udnie(uploadImage.getBytes(), uploadImage.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnData returnData = getReturnData(fileBytes);
        return JSON.toJSONString(returnData);
    }
}
