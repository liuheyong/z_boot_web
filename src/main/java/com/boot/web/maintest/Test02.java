package com.boot.web.maintest;

import com.boot.web.defaultcontroller.DefaultController;

/**
 * @author: LiuHeYong
 * @create: 2019-04-08
 * @exception:
 * @description: Test02
 **/
public class Test02 extends DefaultController {

    /*@Autowired
    private ELogoNavigationBarService eLogoNavigationBarService;
    @Autowired
    private EBannerService eBannerService;
    @Autowired
    private EProductService eProductService;
    @Autowired
    private ECooperateMerService eCooperateMerService;
    @Autowired
    private EBroadCastService broadCastService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private AgentMerInfoService agentMerInfoService;

    @RequestMapping(value = Constants.ODM + "/getEHomePageData")
    @ResponseBody
    public Result getEHomePageData() {
        Result result = new Result();
        Map<String, Object> model = new HashMap<String, Object>(4);
        try {
            String agentMerSeq = getOdmSession(request).getAttribute(OdmLoginSession.ODM_AGENTMERSEQ);
            AgentMerInfo merInfo = new AgentMerInfo();
            merInfo.setAgentMerSeq(agentMerSeq);
            Optional.ofNullable(agentMerInfoService.queryAgentMerInfo(merInfo)).orElseThrow(() -> new CoreException("该分销商不存在"));
            //logo和导航
            ELogoNavigationBar eLogoNavigationBar = new ELogoNavigationBar();
            eLogoNavigationBar.setAgentMerSeq(agentMerSeq);
            Optional<ELogoNavigationBar> optEProductResponse = Optional.ofNullable(eLogoNavigationBarService.queryELogoNavigationBarInfo(eLogoNavigationBar));
            if (optEProductResponse.isPresent()) {
                model.put("eLogoNavigationBar", optEProductResponse.get());
            } else {
                model.put("eLogoNavigationBar", "");
            }
            //banner
            EBanner eBanner = new EBanner();
            eBanner.setAgentMerSeq(agentMerSeq);
            Optional<QueryEBannerResponse> optEBannerResponse = Optional.ofNullable(eBannerService.queryEBannerList(eBanner));
            Map<String, Object> eBannerListModel = optEBannerResponse.map(QueryEBannerResponse::getEBannerList).map(eBannerList -> {
                model.put("eBannerList", eBannerList);
                return model;
            }).orElseGet(() -> {
                model.put("eBannerList", "");
                return model;
            });
            //合作商户
            ECooperateMerController eCooperateMer = new ECooperateMerController();
            eCooperateMer.setAgentMerSeq(agentMerSeq);
            Optional<QueryECooperateMerResponse> optECooperateMerResponse = Optional.ofNullable(eCooperateMerService.queryECooperateMerListPage(eCooperateMer));
            Map<String, Object> eCooperateMerListModel = optECooperateMerResponse.map(QueryECooperateMerResponse::geteCooperateMerList).map(eCooperateMerList -> {
                model.put("eCooperateMerList", eCooperateMerList);
                return model;
            }).orElseGet(() -> {
                model.put("eCooperateMerList", "");
                return model;
            });
            //产品
            EProduct eProduct = new EProduct();
            eProduct.setAgentMerSeq(agentMerSeq);
            Optional<QueryEProductResponse> opteProductResponse = Optional.ofNullable(eProductService.queryEProductOrderListPage(eProduct));
            Map<String, Object> eProductListModel = opteProductResponse.map(QueryEProductResponse::geteProductList).map(eProductList -> {
                model.put("eProductList", eProductList);
                return model;
            }).orElseGet(() -> {
                model.put("eProductList", "");
                return model;
            });
            //广播
            BroadCast broadCast = new BroadCast();
            broadCast.setAgentMerSeq(agentMerSeq);
            Optional<QueryBroadCastResponse> optBroadCastResponse = Optional.ofNullable(broadCastService.queryBroadCastListPage(broadCast));
            Map<String, Object> ebroadCastListModel = optBroadCastResponse.map(QueryBroadCastResponse::getBroadCastList).map(eBroadCastList -> {
                model.put("eBroadCastList", eBroadCastList);
                return model;
            }).orElseGet(() -> {
                model.put("eBroadCastList", "");
                return model;
            });
            result.setResultCode(Constants.RESULT_SUCCESS);
            result.setResultdata(model);
        } catch (CoreException e) {
            log.error(e);
            result.setResultCode(Constants.RESULT_FAIL);
            result.setResultMsg(e.getCode());
        } catch (Exception e) {
            log.error(e);
            result.setResultCode(Constants.RESULT_FAIL);
            result.setResultMsg("系统异常");
        }
        return result;
    }*/

}
