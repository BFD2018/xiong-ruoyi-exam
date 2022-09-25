import request from '@/utils/request'

// 查询学院对应的专业
export function getCollege2Subject() {
  return request({
    url: '/exam/course/college/subject/all',
    method: 'get'
  })
}

// 根据学院id查询部门中专业
export function getSubjectByDeptId(id) {
  return request({
    url: '/system/dept/subject/' + id,
    method: 'get'
  })
}

// 查询部门树结构列表
export function getDeptTreeList() {
  return request({
    url: '/system/dept/tree/list',
    method: 'get'
  })
}

// 查询所有学院
export function getCollegeList() {
  return request({
    url: '/system/dept/college/list',
    method: 'get'
  })
}
// 查询所有教师
export function getTeacherList() {
  return request({
    url: '/system/dept/college/teacher/list',
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
