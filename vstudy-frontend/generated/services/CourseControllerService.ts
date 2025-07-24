/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { Course } from '../models/Course';
import type { Result } from '../models/Result';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class CourseControllerService {
    /**
     * addUser
     * @param course course
     * @returns Result OK
     * @throws ApiError
     */
    public static addUserUsingPost1(
        course: Course,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/course/add',
            body: course,
        });
    }
    /**
     * delUser
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static delUserUsingDelete1(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/course/del/{id}',
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
    public static getAllUsingGet1(): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/course/getAll',
        });
    }
    /**
     * getCourseByCourseId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getCourseByCourseIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/course/getByCourseId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * getCourseByTeacherId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getCourseByTeacherIdUsingGet(
        id?: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/course/getCourseByTeacherId',
            query: {
                'id': id,
            },
        });
    }
    /**
     * page
     * @param current current
     * @param size size
     * @returns Result OK
     * @throws ApiError
     */
    public static pageUsingGet(
        current: number = 1,
        size: number = 10,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/course/page',
            query: {
                'current': current,
                'size': size,
            },
        });
    }
    /**
     * updateCourseById
     * @param course course
     * @returns Result OK
     * @throws ApiError
     */
    public static updateCourseByIdUsingPut(
        course: Course,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/course/update',
            body: course,
        });
    }
}
