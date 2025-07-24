/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Result } from '../models/Result';
import type { Teacher } from '../models/Teacher';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class TeacherControllerService {
    /**
     * addUser
     * @param teacher teacher
     * @returns Result OK
     * @throws ApiError
     */
    public static addUserUsingPost4(
        teacher: Teacher,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/teacher/add',
            body: teacher,
        });
    }
    /**
     * delUser
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static delUserUsingDelete4(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/teacher/del/{id}',
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
    public static getAllUsingGet4(): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/teacher/getAll',
        });
    }
    /**
     * getTeacherByTeacherId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getTeacherByTeacherIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/teacher/getByTeacherId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * getTeacherNameByTeacherId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getTeacherNameByTeacherIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/teacher/getTeacherNameByTeacherId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * updateTeacherById
     * @param teacher teacher
     * @returns Result OK
     * @throws ApiError
     */
    public static updateTeacherByIdUsingPut(
        teacher: Teacher,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/teacher/update',
            body: teacher,
        });
    }
}
