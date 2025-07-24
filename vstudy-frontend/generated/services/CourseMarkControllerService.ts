/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { CourseMark } from '../models/CourseMark';
import type { Result } from '../models/Result';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class CourseMarkControllerService {
    /**
     * addUser
     * @param courseMark courseMark
     * @returns Result OK
     * @throws ApiError
     */
    public static addUserUsingPost2(
        courseMark: CourseMark,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/courseMark/add',
            body: courseMark,
        });
    }
    /**
     * delUser
     * @param courseId courseId
     * @param studentId studentId
     * @returns Result OK
     * @throws ApiError
     */
    public static delUserUsingDelete2(
        courseId: number,
        studentId?: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/courseMark/del/{courseId}',
            path: {
                'courseId': courseId,
            },
            query: {
                'studentId': studentId,
            },
        });
    }
    /**
     * getAll
     * @returns Result OK
     * @throws ApiError
     */
    public static getAllUsingGet2(): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/courseMark/getAll',
        });
    }
    /**
     * getCourseMarkByCourseMarkId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getCourseMarkByCourseMarkIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/courseMark/getByCourseMarkId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * getByStudentId
     * @param id id
     * @returns Result OK
     * @throws ApiError
     */
    public static getByStudentIdUsingGet(
        id: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/courseMark/getByStudentId/{id}',
            path: {
                'id': id,
            },
        });
    }
    /**
     * getByStudentIdAndCourseId
     * @param courseId courseId
     * @param studentId studentId
     * @returns Result OK
     * @throws ApiError
     */
    public static getByStudentIdAndCourseIdUsingGet(
        courseId: number,
        studentId?: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/courseMark/getByStudentIdAndCourseId/{courseId}',
            path: {
                'courseId': courseId,
            },
            query: {
                'studentId': studentId,
            },
        });
    }
    /**
     * page
     * @param current current
     * @param size size
     * @param studentId studentId
     * @returns Result OK
     * @throws ApiError
     */
    public static pageUsingGet1(
        current: number = 1,
        size: number = 10,
        studentId?: number,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/courseMark/page',
            query: {
                'current': current,
                'size': size,
                'studentId': studentId,
            },
        });
    }
    /**
     * updateCourseMarkById
     * @param courseMark courseMark
     * @returns Result OK
     * @throws ApiError
     */
    public static updateCourseMarkByIdUsingPut(
        courseMark: CourseMark,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/courseMark/update',
            body: courseMark,
        });
    }
    /**
     * updateCourseMark
     * @param courseMark courseMark
     * @returns Result OK
     * @throws ApiError
     */
    public static updateCourseMarkUsingPut(
        courseMark: CourseMark,
    ): CancelablePromise<Result> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/courseMark/updateCourseMark',
            body: courseMark,
        });
    }
}
