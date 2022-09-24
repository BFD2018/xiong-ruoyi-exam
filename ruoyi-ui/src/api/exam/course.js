import request from '@/utils/request'

// 查询学院对应的专业
export function getCollege2Subject() {
  return request({
    url: '/exam/course/college/subject/all',
    method: 'get'
  })
}

// 查询课程列表
export function listCourse(query) {
  return request({
    url: '/exam/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程详细
export function getCourse(id) {
  return request({
    url: '/exam/course/' + id,
    method: 'get'
  })
}

// 新增课程
export function addCourse(data) {
  return request({
    url: '/exam/course',
    method: 'post',
    data: data
  })
}

// 修改课程
export function updateCourse(data) {
  return request({
    url: '/exam/course',
    method: 'put',
    data: data
  })
}

// 删除课程
export function delCourse(id) {
  return request({
    url: '/exam/course/' + id,
    method: 'delete'
  })
}
