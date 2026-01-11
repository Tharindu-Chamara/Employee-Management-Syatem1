package edu.example.billingservice.grpc;

import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;

@GrpcService
@Slf4j
public class BillingGrpcService extends BillingServiceImplBase{

    @Override
    public void createBillingAccount(billing.BillingRequest request,
                                     StreamObserver<BillingResponse> responseObserver) {

        log.info("createBillingAccount request received {}", request.toString());
        super.createBillingAccount(request, responseObserver);

        BillingResponse response= BillingResponse.newBuilder()
                .setAccountId("1245")
                .setStatus("success")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }





}
