/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Result } from '../models/Result';
import type { Student } from '../models/Student';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class StudentControllerService {
    /**
     * addUser
     * @param student student
     * @returns Result OK
     * @throws ApiError
     */
    public static addUserUsingPost3(
        student: Student,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/student/add',
            body: student,
        });
    }
    /**
     * delUser
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static delUserUsingDelete3(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/student/del/{id}',
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
    public static getAllUsingGet3(): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/student/getAll',
        });
    }
    /**
     * getStudentByStudentId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getStudentByStudentIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/student/getByStudentId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * updateStudentById
     * @param student student
     * @returns Result OK
     * @throws ApiError
     */
    public static updateStudentByIdUsingPut(
        student: Student,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/student/update',
            body: student,
        });
    }
}
