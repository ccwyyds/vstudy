/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Result } from '../models/Result';
import type { User } from '../models/User';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class UserControllerService {
    /**
     * getUserDetail
     * @param authorization Authorization
     * @returns Result OK
     * @throws ApiError
     */
    public static getUserDetailUsingGet(
        authorization: string,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/detail',
            headers: {
                'Authorization': authorization,
            },
        });
    }
    /**
     * login
     * @param user user
     * @returns Result OK
     * @throws ApiError
     */
    public static loginUsingPost(
        user: User,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/login',
            body: user,
        });
    }
}
