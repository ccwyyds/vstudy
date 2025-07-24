/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Admin } from '../models/Admin';
import type { Result } from '../models/Result';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class AdminControllerService {
    /**
     * addUser
     * @param admin admin
     * @returns Result OK
     * @throws ApiError
     */
    public static addUserUsingPost(
        admin: Admin,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/admin/add',
            body: admin,
        });
    }
    /**
     * delUser
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static delUserUsingDelete(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/admin/del/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * getAll
     * @returns Result OK
     * @throws ApiError
     */
    public static getAllUsingGet(): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/admin/getAll',
        });
    }
    /**
     * getAdminByAdminId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getAdminByAdminIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/admin/getByAdminId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * updateAdminById
     * @param admin admin
     * @returns Result OK
     * @throws ApiError
     */
    public static updateAdminByIdUsingPut(
        admin: Admin,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/admin/update',
            body: admin,
        });
    }
}
